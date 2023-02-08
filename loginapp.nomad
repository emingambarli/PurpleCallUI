job "loginapp" {
  group "springboot" {
    count = 2
    task "loginapp" {
      driver = "docker"
      config {
        image = "shashwot/springboot-app:200919-eb762c8"
        port_map {
          app = 8090
        }
      }
      }
      resources {
        memory = 1024
        cpu = 1000
        network {
          port "app" {}
        }
      }
    }
  }