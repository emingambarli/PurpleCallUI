<h3 align="center">Project Title</h3>

<p align="center">
  <a href="" rel="noopener">
 <img src="img/1.png" alt="Project logo"></a>
</p>

<div align="center">


</div>

---

<p align="center"> Springboot application working on nomad cluster.
    <br> 
</p>

## 📝 Table of Contents
- [About](#about)
- [Deployment](#deployment)
- [Social Links](#sociallinks)

## 🚀 About <a name = "about"></a>

I use my own small Springboot Webapp and Dockerize with Dockerfile (you can see this in this repo). After that, I wrote 

## 🚀 Deployment <a name = "deployment"></a>

The project has 2 nomads(1 server, 1 client) registered in the consul server with consul agents inside the nomads. Webapp deployed to nomad server and nomad server creates a job on own and client node. I used Jenkins pipeline to create a docker image and push it to the repository automatically. 

<img src="img/2.png" alt="nomad1">
<img src="img/3.png" alt="nomad2">
<img src="img/4.png" alt="Jenkins">

## 🎉 Social Links <a name = "sociallinks"></a>

<a href="https://www.linkedin.com/in/emin-gambarli/">
<img border="0" alt="Linkedin" src="img/linkedin.png" width="50" height="50">
</a>

<a href="https://hub.docker.com/repository/docker/emn503/loginapp/general">
<img border="0" alt="dockerhub" src="img/dockerhub.png" width="50" height="50">
</a>