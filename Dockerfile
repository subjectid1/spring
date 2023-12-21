# syntax = docker/dockerfile:experimental
FROM gradle:latest as builder

WORKDIR app
COPY . .
RUN --mount=type=cache,target=/home/gradle/.gradle app/gradlew bootRun

 