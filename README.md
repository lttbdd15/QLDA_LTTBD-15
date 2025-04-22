A simple Android app to manage your daily tasks and notes

## Description

Key features include:

* Creating new tasks/notes

* Editing existing entries

## Demo / Screenshots
Screen_1

![getstartedscreen](https://github.com/user-attachments/assets/34d7cc87-3248-4008-8322-0916223c900e)

Screen_2


![loginscreen1](https://github.com/user-attachments/assets/87192e03-1a94-4a82-b51e-cac4cb459774)
![loginscreen](https://github.com/user-attachments/assets/42bbd751-9961-4155-bbd8-a778050a82ca)


Screen_3

![recentnotesscreen](https://github.com/user-attachments/assets/564ed6e4-ad48-448a-8e13-9ecbf5c0dda4)


Screen_4

![editnotescreen](https://github.com/user-attachments/assets/ef1009e7-fa95-496d-8aff-7f0085490f90)

Screen_5

![profilescreen](https://github.com/user-attachments/assets/799037f8-ba00-4179-8dd2-e50772e3d517)


## Features

 *Add New Task:** Easily create new tasks with a title and description.
 
 *User-Friendly Interface:** Simple and easy to navigate design.
 
 *Manage your account:** Simple to custom your account


## System Requirements

* Minimum Android Version:API level 21 (Android 5.0 Lollipop)

## Installation and Setup

1.  **Clone the repository:

   git clone https://github.com/huytran2005/NoteMobileApp.git

3.  **Open the project in Android Studio:**
  
4.  **Sync Gradle:**

    * Android Studio should automatically sync the Gradle files. Make sure you have an internet connection.
      
5. **Connect firebase**

1.Go to tool in android studio then click firebase
      ![1](https://github.com/user-attachments/assets/5ea00190-0893-4aa5-b631-3b49fba82b61)
2.Click authenticate using google
       ![2](https://github.com/user-attachments/assets/325fea18-aedf-4fed-aead-43a89f3893c2)
3.Click connect



4.Go to google consosole 

![image](https://github.com/user-attachments/assets/8488367b-ed8b-4a84-b164-b5d24de5b3ce)


5.Create name for your project
   ![image](https://github.com/user-attachments/assets/de0cf588-d830-41db-bdee-1c8abefcb3ca)

6. Click icon android

  ![image](https://github.com/user-attachments/assets/5d71d683-e8f5-4370-82ab-9c42f3cc315c)

  
7.Go to Build.gradle.kts (Module:app),find package android name after that input your package name 
    
  *Find name package app
    
  ![image](https://github.com/user-attachments/assets/7c122662-be20-4130-ae04-1ba88c83b72e)
      
  *Input your package name app
    
  ![image](https://github.com/user-attachments/assets/9decfe0a-b073-4a04-b091-fa6a050241c4)
8. Find and Input your SHA1

 *Click gradle icon
 
 ![image](https://github.com/user-attachments/assets/3f29e523-d9e8-4289-ba1e-2140e376bd35)

 *Click execute gradle task

 ![image](https://github.com/user-attachments/assets/0e7d9bba-112e-4d3d-b965-1f908649983f)

 *Input gradle signingreport
 
 ![My Application – Login kt  My_Application app main  22_04_2025 12_03_08 CH](https://github.com/user-attachments/assets/e39727d8-f9f0-4279-a5f7-05b2e9d455b1)

 * Get SHA1 in console

   ![image](https://github.com/user-attachments/assets/77af4e90-cce1-4453-b1c8-a6ac205e253e)
  
 *Input your SHA1 in firebase

 9.Find web key API on firebase and input to my code
 
 *Click  connecting methoh

![image](https://github.com/user-attachments/assets/f3da80c8-4e00-4231-aabb-1fb8496e69a2)


*Find Web client id

![image](https://github.com/user-attachments/assets/9380e6b7-3851-4ccf-acd6-512b2b74748f)

* Input your client id to file sigingGoogle.kt line 68
  ![image](https://github.com/user-attachments/assets/ee2f5c13-5289-43a0-968a-28ec0fd37b8e)

 
