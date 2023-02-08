job "loginapp" {
  group "springboot" {
    count = 2
    task "loginapp" {
      driver = "docker"
      config {
        image = "emn503/loginapp:1"
        port_map {
          app = 80
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