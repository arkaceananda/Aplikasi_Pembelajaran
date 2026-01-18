<div>
  <img style="100%" src="https://capsule-render.vercel.app/api?type=waving&height=100&section=header&reversal=true&fontSize=70&fontColor=FFFFFF&fontAlign=50&fontAlignY=50&stroke=-&descSize=20&descAlign=50&descAlignY=50&textBg=false&color=random"  />
</div>

# 📱 Kotlin Math App (Jetpack Compose)

A simple Android application built with **Kotlin** and **Jetpack Compose**  
that helps users analyze numbers and calculate arithmetic sequences.

This project was created as a **logic & UI practice** and is suitable for
school assignments such as **UKK / PKL preparation**.

---

## ✨ Features

### 🔢 Number Classification
Users can check whether a number is:
- Zero
- Positive or Negative
- Odd or Even

### 📐 Arithmetic Sequence Calculator
Calculate:
- First number (a)
- Difference (b)
- Total terms (n)
- Arithmetic sequence list
- Total sum
- Average value

### 🎨 Modern UI
- Built using **`Jetpack Compose`**
- Clean and minimal design
- Fully native Android (no framework)

---

## 🛠 Tech Stack

- **Language**: `Kotlin`
- **UI**: `Jetpack Compose`
- **IDE**: `Android Studio`
- **Architecture**: Simple OOP (Logic separated from UI)

---

## 📂 Project Structure

```

com.example.projectname
│
├── ui/
│   ├── screen/
│   │   ├── NumberCheckScreen.kt
│   │   ├── ArithmeticScreen.kt
│   │
│   └── theme/
│       ├── Color.kt
│       ├── Theme.kt
│
├── logic/
│   ├── NumberChecker.kt
│   ├── ArithmeticSequence.kt
│
└── MainActivity.kt

````

---

## 🧠 Core Logic Example

### Number Classification
```kotlin
fun checkNumber(number: Int): String {
    return when {
        number == 0 -> "Zero"
        number > 0 && number % 2 == 0 -> "Positive Even"
        number > 0 -> "Positive Odd"
        number % 2 == 0 -> "Negative Even"
        else -> "Negative Odd"
    }
}
````

### Arithmetic Sequence

```kotlin
class ArithmeticSequence(
    private val a: Int,
    private val b: Int,
    private val n: Int
) {
    fun sequence(): List<Int> =
        (0 until n).map { a + it * b }

    fun sum(): Int =
        n * (2 * a + (n - 1) * b) / 2

    fun average(): Double =
        sum().toDouble() / n
}
```

---

## 🚀 How to Run

1. Clone this repository
2. Open it with **Android Studio**
3. Use **Empty Activity (Jetpack Compose)**
4. Run on emulator or physical device

---

## 🎯 Purpose

* Practice **Kotlin fundamentals**
* Understand **OOP basics**
* Learn **Jetpack Compose UI**
* Prepare for **UKK / Internship (PKL)**

---

## 👨‍💻 Author

**Arka Aceananda**
Student | Aspiring Mobile App Developer
Focused on `Kotlin`, `Jetpack Compose`, and `Flutter`

---

## 📄 License

This project is for educational purposes only.

<div>
  <img style="100%" src="https://capsule-render.vercel.app/api?type=waving&height=100&section=footer&reversal=false&fontSize=70&fontColor=FFFFFF&fontAlign=50&fontAlignY=50&stroke=-&descSize=20&descAlign=50&descAlignY=50&color=random"  />
</div>
