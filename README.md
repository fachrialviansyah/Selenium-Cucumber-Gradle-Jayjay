# Tugas Course Module 21 QA Engineer Automation di Jayjay
### Tugas Project ini automation testing aplikasi web https://www.saucedemo.com/v1/

### :zap: Teknologi yang digunakan
- Bahasa Pemrogramman Java
- Aplikasi IntelliJ IDEA Community
- Selenium (Untuk otomatisasi browser)
- JUnit (Untuk menjalankan test)
- Gherkin dan Framework Cucumber (Untuk menjalankan test dan report test)
<img src="https://skillicons.dev/icons?i=java,idea,selenium,gradle,gherkin"/>

---

### :zap: Step Installasi Project
1. Clone Repository git clone https://github.com/fachrialviansyah/Selenium-Cucumber-Gradle-Jayjay.git
2. Install Dependensi jalankan perintah: **./gradlew build**
3. Running Test, jalankan perintah: **./gradlew test**
4. Melakukan test yang hanya 1 di pilih: **./gradlew test -Dcucumber.options="--tags @regression"**
5. View report cucumber dengan format html: **report/cucumber.html**

### :zap: Struktur Project
    │── src 
    │   └── test
    │       ├── java
    │       │   ├── com.fachri.page                     # Page Object Models (POM)
    │       │   │   ├── HomePage.java
    │       │   │   └── LoginPage.java
    │       │   ├── stepdef                             # Step Definitions
    │       │   │   ├── CucumberHooks.java
    │       │   │   ├── HomeStepDef.java
    │       │   │   ├── LoginStepDef.java
    │       │   └── BaseTest.java
    │       │   └── CucumberTest.java
    │       └── resources
    │           └── login.feature                       # Feature Files (BDD)
    ├── .gitignore                                      # File untuk mengecualikan file tertentu dari git
    ├── build.gradle                                    # File konfigurasi Gradle
    ├── gradlew                                         # Wrapper untuk Gradle (Linux/Mac)
    ├── gradlew.bat                                     # Wrapper untuk Gradle (Windows)
    ├── config.properties                               # File konfigurasi proyek
    └── README.md                                       # Dokumentasi proyek

### :zap: Hasil penulisan gherkin
    Feature: Login
        @positive-test
        Scenario: Login with valid username and password
         Given user is on login page
         When user input username with "standard_user"
         And user input password "secret_sauce"
         And user click login button
         Then user is on homepage

        @negative-test
        Scenario: Login with valid username and password
         Given user is on login page
         When user input username with "standard_user"
         And user input password "invalid"
         And user click login button
         Then user see error messege "Epic sadface: Username and password do not match any user in this service"

        @batas-test
        Scenario: Login with valid username
         Given user is on login page
         When user input username with "username_salah12345789"
         And user input password "secret_sauce"
         And user click login button
         Then user see error messege "Epic sadface: Username and password do not match any user in this service"

### :zap: Hasil report test cucumber

<img width="1067" height="734" alt="image" src="https://github.com/user-attachments/assets/04c36028-7ace-4de5-9d7a-13307b692e62" />

### :zap: Github Actions
Feature: Login
        @positive-test
        Scenario: Login with valid username and password
         Given user is on login page
         When user input username with "standard_user"
         And user input password "secret_sauce"
         And user click login button
         Then user is on homepage



