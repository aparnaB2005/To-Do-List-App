# 📋 To-Do List App (Android)

A simple and elegant **To-Do List App** built using **MVVM architecture**, **Room Database**, and **LiveData**. Users can add, update, and delete tasks — with real-time UI updates and local data persistence.

---

## ✨ Features

- ✅ Add new tasks
- 📝 Edit existing tasks
- ❌ Delete completed or unwanted tasks
- 📋 All tasks shown using **RecyclerView**
- 🔄 Live UI updates with **LiveData**
- 💾 Persistent storage using **Room Database**
- 🧠 Clean **MVVM** architecture

---

## 🧠 Tech Stack

- **Language:** Java
- **Architecture:** MVVM (Model-View-ViewModel)
- **UI:** XML Layouts, RecyclerView, Dialogs
- **Persistence:** Room Database (DAO, Entity)
- **Reactive:** LiveData, ViewModel
- **IDE:** Android Studio
- **Build Tool:** Gradle



## 📦 Project Structure
To-Do-List-App/
│
├── app/
│ ├── java/com/example/project_to_do_list/
│ │ ├── MainActivity.java
│ │ ├── TaskEntity.java
│ │ ├── TaskDao.java
│ │ ├── TaskDatabase.java
│ │ ├── TaskRepository.java
│ │ ├── ViewModel.java
│ │ └── RecyclerViewAdapter.java
│ └── res/
│ ├── layout/
│ ├── values/
│ └── drawable/
└── build.gradle.kts