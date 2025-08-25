# Tugas Course Module 21 QA Engineer Automation di Jayjay
### Tugas Project ini automation testing aplikasi web https://www.saucedemo.com/v1/

### :zap: Teknologi yang digunakan
- Bahasa Pemrogramman Java
- Aplikasi IntelliJ IDEA Community
- Selenium (Untuk otomatisasi browser)
- JUnit (Untuk menjalankan test)
- Gherkin dan Framework Cucumber (Untuk menjalankan test dan report test)
<img src="https://skillicons.dev/icons?i=selenium,gherkin,gradle,java,idea"/>

---

### :zap: Step Installasi Project
1. Clone Repository git clone https://github.com/fachrialviansyah/Selenium-Cucumber-Gradle-Jayjay.git
2. Install Dependensi jalankan perintah: ./gradlew build
3. Running Test, jalankan perintah: ./gradlew test
4. Melakukan test yang hanya 1 di pilih: ./gradlew test -Dcucumber.options="--tags @regression"
5. View report cucumber dengan format html: report/cucumber.html

### :zap: Struktur Project
│── src 
│   └── test
│       ├── java
│       │   ├── page                    # Page Object Models (POM)
│       │   │   ├── HomePage.java
│       │   │   └── LoginPage.java
│       │   ├── stepdef                 # Step Definitions
│       │   │   ├── BaseTest.java
│       │   │   ├── CucumberHooks.java
│       │   │   ├── HomeStepDef.java
│       │   │   ├── LoginStepDef.java
│       │   │   └── CucumberTest.java
│       └── resources
│           └── features               # Feature Files (BDD)
│               └── login.feature
├── .gitignore                          # File untuk mengecualikan file tertentu dari git
├── build.gradle                        # File konfigurasi Gradle
├── gradlew                             # Wrapper untuk Gradle (Linux/Mac)
├── gradlew.bat                         # Wrapper untuk Gradle (Windows)
├── config.properties                   # File konfigurasi proyek
└── README.md                           # Dokumentasi proyek
