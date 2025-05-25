# ✅ Project Code Conventions (Java + JavaFX)

## 1. 🔤 Naming Conventions

### 📁 Packages

* All lowercase, singular.
* Use your domain: `com.projectg3.model`, `com.projectg3.view`

### 📦 Classes

* PascalCase (EachWordCapitalized)
* Class names should be nouns or noun phrases
  ✅ `UserController`, `LoginService`, `DatabaseConnection`

### 🔧 Methods

* camelCase
* Method names should be verbs or verb phrases
  ✅ `getUserData()`, `loadScene()`, `calculateTotal()`

### 🎯 Variables

* camelCase
* Be descriptive, avoid `temp`, `data`, `x` (unless in loops)

### ⚙️ Constants

* ALL\_UPPERCASE\_WITH\_UNDERSCORES
  ✅ `MAX_ATTEMPTS`, `DEFAULT_TIMEOUT`

---

## 2. 📐 Project Structure

```
src/
 └─ main/
     └─ java/
         └─ com.projectg3/
             ├─ model/       ← Data classes (POJOs)
             ├─ view/        ← JavaFX .fxml + visual logic
             ├─ controller/  ← JavaFX controllers
             ├─ service/     ← Business logic
             ├─ dao/         ← Database or file access
             └─ util/        ← Helpers & tools
```

---

## 3. ⬛ Formatting & Style

* **Indentation**: 4 spaces, no tabs
* **Braces**: Always use `{}` even for one-liners

  ```java
  if (valid) {
      doSomething();
  }
  ```
* **One class per file**, public class must match file name
* **Max line length**: 100 characters
* **Empty lines**: Use to separate logical blocks

---

## 4. 🎭 Comments

* Use Javadoc for public classes and methods

  ```java
  /**
   * Calculates the user's age based on birthdate.
   */
  public int calculateAge(LocalDate birthdate) { ... }
  ```

* In-line comments should **explain why**, not what
  ❌ `// increment i`
  ✅ `// Skip the first element since it's already processed`

---

## 5. 🧪 Testing and Debugging

* Use `System.out.println()` for quick debugging, but **remove before commit**
* Unit tests in `src/test/java`
* Use `assert` only for developer-side logic, not user input

---

## 6. 🧼 Clean Code Rules

* Avoid magic numbers → extract as constants
* Avoid duplicate code → extract methods
* Small methods (<40 lines) are ideal
* Limit class responsibilities: **Single Responsibility Principle**

---

## 7. 🛑 Git Commit Messages

* Format: `type(scope): short description`

Examples:

```
feat(login): implement login form validation
fix(service): prevent crash on null response
refactor(controller): extract scene switch logic
```

Types: `feat`, `fix`, `docs`, `style`, `refactor`, `test`, `chore`

---

## 🧭 Final Note

> **“Code is read more often than it's written.”**
> Following a shared standard means faster reviews, easier debugging, and a happier team.
