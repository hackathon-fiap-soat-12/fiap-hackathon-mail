variable "aws_region" {
  type        = string
  default     = "us-east-1"
  description = "AWS Account region"
}

variable "aws_access_key_id" {
  description = "AWS Access Key ID"
  sensitive   = true
}

variable "aws_secret_access_key" {
  description = "AWS Secret Access Key"
  sensitive   = true
}

variable "aws_session_token" {
  description = "AWS Session Token"
  sensitive   = true
}

variable "eks_cluster_name" {
  type        = string
  default     = "fiap-hackathon-eks-cluster"
  description = "EKS Cluster name"
}

variable "ecr_repository_name" {
  type        = string
  default     = "fiap-hackathon-mail-app"
  description = "AWS ECR repository name"
}

variable "server_port" {
  type        = number
  default     = 8100
  description = "mail App server port"
}

variable "otlp_endpoint" {
  type        = string
  default     = "http://alloy.monitoring:4317"
  description = "OTLP exporter endpoint"
}

variable "smtp_host" {
  type        = string
  default     = "smtp.gmail.com"
  description = "SMTP Host"
}

variable "mail_port" {
  type        = number
  default     = 587
  description = "Mail port"
}

variable "mail_username" {
  type        = string
  description = "Mail username"
}

variable "mail_password" {
  type        = string
  description = "Mail password"
}
