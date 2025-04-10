resource "kubernetes_secret" "mail_secret" {
  metadata {
    name      = "fiap-hackathon-mail-secret"
    namespace = kubernetes_namespace.mail_namespace.metadata[0].name
  }

  data = {
    aws_access_key_id     = var.aws_access_key_id
    aws_secret_access_key = var.aws_secret_access_key
    aws_session_token     = var.aws_session_token
    aws_region            = var.aws_region
    smtp_host             = var.smtp_host
    mail_port             = var.mail_port
    mail_username         = var.mail_username
    mail_password         = var.mail_password
  }

  depends_on = [kubernetes_namespace.mail_namespace]
}
