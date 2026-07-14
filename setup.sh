#!/bin/bash

echo "======================================"
echo " Library Management - Environment Setup"
echo "======================================"

# ─────────────────────────────────────────
# Step 1: Set Java 17
# ─────────────────────────────────────────
echo ""
echo "[1/4] Setting up Java 17..."

export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH

# Make it permanent for this Codespace
if ! grep -q "java-17-openjdk-amd64" ~/.bashrc; then
    echo 'export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64' >> ~/.bashrc
    echo 'export PATH=$JAVA_HOME/bin:$PATH' >> ~/.bashrc
    echo "   → Java 17 added to ~/.bashrc"
else
    echo "   → Java 17 already in ~/.bashrc, skipping"
fi

java -version

# ─────────────────────────────────────────
# Step 2: Start MySQL
# ─────────────────────────────────────────
echo ""
echo "[2/4] Starting MySQL..."
sudo service mysql start
sudo service mysql status

# ─────────────────────────────────────────
# Step 3: Create DB and user
# ─────────────────────────────────────────
echo ""
echo "[3/4] Setting up database and user..."

sudo mysql -u root <<EOF
CREATE DATABASE IF NOT EXISTS library_db;
CREATE USER IF NOT EXISTS 'library_user'@'localhost' IDENTIFIED BY 'library123';
GRANT ALL PRIVILEGES ON library_db.* TO 'library_user'@'localhost';
FLUSH PRIVILEGES;
EOF

echo "   → library_db and library_user ready"

# ─────────────────────────────────────────
# Step 4: Verify build
# ─────────────────────────────────────────
echo ""
echo "[4/4] Verifying Maven build..."
./mvnw clean compile

echo ""
echo "======================================"
echo " Setup complete! To run the app:"
echo " ./mvnw spring-boot:run"
echo "======================================"
