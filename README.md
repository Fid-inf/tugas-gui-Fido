# Java GUI Exploration: Student List Manager

**Name:** Fido Priasa Setyono Putra  
**NIM:** F1D02410048  
**Class:** 5A - Object-Oriented Programming (Pemrograman Berorientasi Objek)  

---

## Project Overview
This project is a Java Swing GUI application designed to manage and display a list of students (NIM and Full Name). It demonstrates the implementation of Object-Oriented Programming (OOP) principles combined with Java's GUI containment hierarchy, layout managers, and event handling.

## Project Structure
The application is separated into three distinct classes:
* **`Mahasiswa.java`** *(Model Class)*: Represents the student entity with `private` attributes (`nim` and `nama`), constructor, getters, and a custom `toString()` method.
* **`DaftarMahasiswaGUI.java`** *(View & Event Handler)*: Builds the graphical user interface using Java Swing, manages the dynamic list of `Mahasiswa` objects using `ArrayList`, and handles user interactions.
* **`MainMahasiswa.java`** *(Entry Point)*: Contains the `main` method to instantiate and launch the GUI application.

---

## GUI Architecture & Implementation

### 1. Component Hierarchy
* **Top-Level Container:** `JFrame` (`frame`) serves as the main application window[cite: 56].
* **Intermediate Containers:** `JPanel` (`panelInput`, `panelTombol`, `panelAtas`) and `JScrollPane` are used to group components and provide scrolling capabilities[cite: 56].
* **Atomic Components:** `JLabel`, `JTextField`, `JButton`, and `JTextArea` handle direct user inputs and outputs[cite: 56].

### 2. Layout Managers
* **`BorderLayout`:** Divides the main `JFrame` and `panelAtas` into `NORTH`, `CENTER`, and `SOUTH` regions[cite: 47].
* **`GridLayout(2, 2)`:** Organizes the NIM and Name labels alongside their respective text fields in `panelInput`.
* **`FlowLayout`:** Aligns the action buttons horizontally at the center of `panelTombol`[cite: 38].

### 3. Event Handling (Delegation Event Model)
* **Event Listener:** Implemented via an inner class `AksiHandler` that implements `ActionListener`[cite: 12, 45].
* **Event Sources:** Registered to `btnTambah` (Add button), `btnHapusSemua` (Clear list button), and `txtNama` (triggers on pressing `Enter`)[cite: 11].
