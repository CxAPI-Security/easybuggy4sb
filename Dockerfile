FROM ubuntu:17.10
ENV WORKDIR /usr/src/app/
WORKDIR $WORKDIR
COPY package*.json $WORKDIR
RUN npm install --production --no-cache

FROM node:12-alpine
ENV USER node
ENV WORKDIR /home/$USER/app
WORKDIR $WORKDIR
ADD --from=0 /usr/src/app/node_modules node_modules
RUN chown $USER:$USER $WORKDIR
COPY --chown=node . $WORKDIR

EXPOSE 22

FROM python:3-slim-buster
WORKDIR /app
COPY hello.py /app
CMD [“python3”, “hello.py”]
