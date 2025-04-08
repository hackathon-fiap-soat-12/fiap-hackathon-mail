resource "kubernetes_secret" "mail_secret" {
  metadata {
    name      = "fiap-hackathon-mail-secret"
    namespace = kubernetes_namespace.mail_namespace.metadata[0].name
  }

  data = {
    AWS_ACCESS_KEY_ID     = var.aws_access_key_id
    AWS_SECRET_ACCESS_KEY = var.aws_secret_access_key
    AWS_SESSION_TOKEN     = var.aws_session_token
    AWS_REGION            = var.aws_region
    SMTP_HOST             = var.smtp_host
    MAIL_PORT             = var.mail_port
    MAIL_USERNAME         = var.mail_username
    MAIL_PASSWORD         = var.mail_password
  }

  depends_on = [kubernetes_namespace.mail_namespace]
}