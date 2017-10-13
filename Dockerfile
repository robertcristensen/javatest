FROM maven:3.5.0-jdk-8 
RUN mkdir -p /usr/src/app
COPY . /usr/src/app
WORKDIR /usr/src/app
