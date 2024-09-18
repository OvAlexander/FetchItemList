# Fetch Hiring List

[![Kotlin](https://img.shields.io/badge/kotlin-1.9.24-blue.svg?logo=kotlin)](http://kotlinlang.org)


Kotlin-based application to take in a JSON, sort it, and display it in an app

## Table of contents

<!--- TOC -->

* **[Introduction](#introduction)**

<!--- END -->

* **References**
    * [Kotlin Docs](https://kotlinlang.org/docs/kotlin-doc.html)
    * [GSON Refernce](https://github.com/google/gson)


## Introduction

The application is comprised of two main aspects JSON reading/parsing and linking information to the UI.

To handle JSON reading, the JSON file is stored in the application's assets folder, where it is then opened by the application and read line by line being stored into a string.

To handle JSON parsing in a third-party library, "GSON" is used to deserialize the data, converting the stored JSON data into a Kotlin object. Then converts it to a list of Item data class objects.

To link the incoming JSON data to the UI, the application utilizes RecyclerView to display a list of items passed through an adapter, ensuring the incoming items can be mapped to the proper UI components.
