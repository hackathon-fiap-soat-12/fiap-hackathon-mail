resource "kubernetes_namespace" "mail_namespace" {
  metadata {
    name = "mail"
  }
}
