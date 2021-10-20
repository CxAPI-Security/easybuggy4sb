package org.t246osslab.easybuggy4sb.vulnerabilities;

import ognl.AbstractMemberAccess;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.t246osslab.easybuggy4sb.Config;
import org.t246osslab.easybuggy4sb.controller.AbstractController;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Locale;
import java.util.Map;

@Controller
public class OGNLExpressionInjectionReflectionController extends AbstractController {

    @RequestMapping(value = Config.APP_ROOT + "/ognleijc-reflection")
    public ModelAndView process(@RequestParam(value = "expression", required = false) String expression,
            ModelAndView mav, Locale locale) {
        setViewAndCommonObjects(mav, locale, "commandinjection-reflection");
        Object result = null;
        String errMessage = "";
        OgnlContext ctx = new OgnlContext(null, null, (new AbstractMemberAccess() {
            public boolean isAccessible(Map context, Object target, Member member, String propertyName) {
                int modifiers = member.getModifiers();// 228
                return Modifier.isPublic(modifiers);// 229
            }
        }));
        if (!StringUtils.isBlank(expression)) {
            try {
                Method getValueMethod
                        = Ognl.class.getMethod("getValue", Object.class, Object.class);
                Method parseExpressionMethod
                        = Ognl.class.getMethod("parseExpression", String.class);

                Object expr = parseExpressionMethod.invoke(Ognl.class, expression.replaceAll("Math\\.", "@Math@"));
                result = getValueMethod.invoke(Ognl.class, expr, ctx);
            } catch (Exception e) {
                if (e.getCause() instanceof OgnlException && ((OgnlException)e.getCause()).getReason() != null) {
                    errMessage = ((OgnlException)e.getCause()).getReason().getMessage();
                }
                log.debug("Exception occurs: ", e);
            } catch (Error e) {
                log.debug("Error occurs: ", e);
            }
        }
        if (expression != null) {
            mav.addObject("expression", expression);
            if (result == null) {
                mav.addObject("errmsg",
                        msg.getMessage("msg.invalid.expression", new String[] { errMessage }, null, locale));
            }
        }
        if (result != null && NumberUtils.isNumber(result.toString())) {
            mav.addObject("result", result);
        }
        return mav;
    }
}
