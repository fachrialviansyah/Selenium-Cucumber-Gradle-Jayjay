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

### :zap: Struktur Project with REST API
    │── src 
    │   └── test
    │       ├── java
    │       │   ├── com.fachri                     
    │       │   ├── helper                                               # File Pendukung Lainnya
    │       │   │   ├── JSONSchemadata                                   # File Schema Data Json
    │       │   │   │   ├── get_list_users.json                        
    │       │   │   │   └── post_create_new_user.json
    │       │   │   └── Endpoint.java
    │       │   │   └── Models.java
    │       │   │   └── Utility.java
    │       │   ├── page                                                 # Page Object Models (POM)
    │       │   │   ├── ApiPage.java
    │       │   │   ├── HomePage.java
    │       │   │   └── LoginPage.java
    │       │   ├── stepdef                                              # Step Definitions
    │       │   │   ├── ApiStepdefs.java                                 # Step Definitions API
    │       │   │   ├── CucumberHooks.java
    │       │   │   ├── HomeStepDef.java
    │       │   │   └── LoginStepDef.java
    │       │   └── ApiTest.java
    │       │   └── BaseTest.java
    │       │   └── CucumberTest.java
    │       └── resources
    │           └── login.feature                                       # Feature Files (BDD)
    │           └── api.feature                                         # Feature Files API (BDD)
    ├── .gitignore                                                      # File untuk mengecualikan file tertentu dari git
    ├── build.gradle                                                    # File konfigurasi Gradle
    ├── gradlew                                                         # Wrapper untuk Gradle (Linux/Mac)
    ├── gradlew.bat                                                     # Wrapper untuk Gradle (Windows)
    ├── config.properties                                               # File konfigurasi proyek
    └── README.md                                                       # Dokumentasi proyek


### :zap: Hasil penulisan Login gherkin
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

### :zap: Hasil penulisan Rest Api gherkin
    Feature: Automation Testing REST API User Controller
          @get-test
          Scenario: Test Get List Data Users
            Given prepare url for "get_list_users"
            When hit api get list users
            Then validation status code is equals 200
            And validation response body get list users
            And validation response json with JSONSchema "get_list_users.json"
        
          @post-test
          Scenario: Test Create user
            Given prepare url for "create_new_user"
            And hit api post create new user
            Then validation status code is equals 201
            And validation response body post create new user
            And validation response json with JSONSchema "post_create_new_user.json"
        
          @put-test
          Scenario: Test Update User
            Given prepare url for "modif_user"
            And hit api post create new user
            Then validation status code is equals 201
            And validation response body post create new user
            And hit api update data
            And validation status code is equals 200
            And validation response body update user
        
          @delete-test
          Scenario: Test Delete User
            Given prepare url for "modif_user"
            When hit api post create new user
            Then validation status code is equals 201
            And validation response body post create new user
            And hit api delete new user
            And validation status code is equals 204
        

### :zap: Hasil report Login test cucumber

<img width="1067" height="734" alt="image" src="https://github.com/user-attachments/assets/04c36028-7ace-4de5-9d7a-13307b692e62" />

### :zap: Hasil report Rest API test cucumber

<img width="807" height="697" alt="image" src="https://github.com/user-attachments/assets/a19780fc-4c9a-4008-9c21-23f5be3aced1" />

### :zap: Github Login Actions
    name: Web Automation Workflow
    on:
      push:
        branches: [ "master" ]
      pull_request:
        branches: [ "master" ]
      workflow_dispatch:
    
    jobs:
      run-automation-test:
        runs-on: ubuntu-latest
    
        steps:
        # download repo
        - uses: actions/checkout@v4
    
        # setup java
        - name: Set up JDK 17
          uses: actions/setup-java@v4
          with:
            java-version: '17'
            distribution: 'temurin'
        
        # install browser
        - name: Setup Chrome
          uses: browser-actions/setup-chrome@v2.1.0
    
        # setup gradlew
        - name: Setup gradlew
          run: chmod +x gradlew
          
        # Execute gradle command for running cucumber test
        - name: Execute Test
          run: ./gradlew cucumber
    
         # Archive Test Result
        - name: Archive Test Result
          uses: actions/upload-artifact@v4.6.2
          if: always()
          with:
            name: Cucumber Report
            path: reports
    
        # Deploy to Github Pages
        - name: Deploy report to Github Pages
          uses: peaceiris/actions-gh-pages@v4.0.0
          with:
            github_token: ${{ secrets.GITHUB_TOKEN }}
            publish_dir: reports

### :zap: Github Rest API Actions
    name: REST API Workflow
        on:
          push:
            branches: [ "master" ]
          pull_request:
            branches: [ "master" ]
          workflow_dispatch:
        
        jobs:
          restAPI-automation-test:
            runs-on: ubuntu-latest
        
            steps:
            # download repo
            - uses: actions/checkout@v4
        
            # setup java
            - name: Set up JDK 17
              uses: actions/setup-java@v4
              with:
                java-version: '17'
                distribution: 'temurin'
            
            # install browser
            - name: Setup Chrome
              uses: browser-actions/setup-chrome@v2.1.0
        
            # setup gradlew
            - name: Setup gradlew
              run: chmod +x gradlew
              
            # Execute gradle command for running cucumber test
            - name: Execute Test
              run: ./gradlew api
        
             # Archive Test Result
            - name: Archive Test Result
              uses: actions/upload-artifact@v4.6.2
              if: always()
              with:
                name: api-report
                path: reports/api
        
            # Deploy to Github Pages
            - name: Deploy report to Github Pages
              uses: peaceiris/actions-gh-pages@v4.0.0
              with:
                github_token: ${{ secrets.GITHUB_TOKEN }}
                publish_dir: reports
            
### :zap: Hasil Login Report Github Actions with framework cucumber
<img width="1072" height="745" alt="image" src="https://github.com/user-attachments/assets/d7de9758-032e-4641-9834-db9108685b51" />

### :zap: Hasil Login Report Jenskin with framework cucumber
<img width="1065" height="743" alt="image" src="https://github.com/user-attachments/assets/2075a570-1e42-42ea-9b02-ed601daa6b4b" />

### :zap: Hasil Status Github Action (Login)
<img width="1354" height="652" alt="image" src="https://github.com/user-attachments/assets/a3d07b95-08b7-45c4-8534-eef82b4e2c3d" />

### :zap: Hasil REST API Github Actions with framework cucumber
<img width="804" height="695" alt="image" src="https://github.com/user-attachments/assets/a90e7527-2225-46ec-afe2-45ac81aa4aeb" />

### :zap: Hasil REST API Jenskin with framework cucumber
<img width="804" height="699" alt="image" src="https://github.com/user-attachments/assets/a1ede80c-d0c6-46bb-8e76-bd4c18a8790e" />

### :zap: Hasil Status Github Action (Rest Api)
<img width="1355" height="650" alt="image" src="https://github.com/user-attachments/assets/f93d5fd0-8e53-497f-aa7f-2340d3e5dc5f" />






