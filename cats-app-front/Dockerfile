FROM node:14
WORKDIR /usr/local/app/cats-app-front
COPY package*.json ./
RUN npm install -g --unsafe-perm=true @angular/cli @angular-devkit/build-angular && npm install --unsafe-perm=true
EXPOSE 4201
CMD ["npm", "start"]