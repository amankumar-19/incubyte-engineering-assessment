FROM node:20-alpine AS build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN sed -i "s#http://localhost:8080/api#/api#g" src/app/core/api.service.ts && npm run build
FROM nginx:1.27-alpine
COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build /app/dist/acme-salary-ui/browser /usr/share/nginx/html
EXPOSE 80
