provider "aws" {
  region  = "us-east-1"
  profile = "default"
}

resource "aws_iam_instance_profile" "profile" {
  name = "my_ec2_profile2"
  role = "TESTING"  # replace with your existing IAM role name
}

resource "aws_instance" "Gitlab_ec2" {
  ami                 = "ami-06ca3ca175f37dd66"
  instance_type       = "t2.micro"
  key_name            = "AWSGitLab2"
  iam_instance_profile = aws_iam_instance_profile.profile.name

  tags = {
    Name = "EC2GitHubActions"
  }
}
