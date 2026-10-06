## Quick Start — команды ./gradlew run, ./gradlew test.

## Git локальный цикл
После добавления новых инструментов — обновляйте .gitignore и делайте санитарный коммит при необходимости.
Если случайно удалили файлы без --cached, восстановитесь из локальной истории/изменений IDE.
Перед push проверяйте «status clean» в IDE и CLI; при расхождениях — ищите источник (новые артефакты/настройки).

git checkout -b feature/DVT-X"
git status
git add .
git commit -m "message"
git push -u origin feature/DVT-X
git fetch --all --prune
git pull --ff-only origin main

git branch --show-current 
git log --oneline
git log --oneline --decorate
git branch -vv

## Правило веток: feature/DVT‑X


## Кодстайл-гайд
Проект следует правилам Google Java Style Guide с адаптацией.
Автоматическая проверка: ./gradlew checkstyleMain

### 1. Именование методов: camelCase
До:    public void add_student(Student s) { }
После: public void addStudent(Student student) { }
Почему: Java Convention требует camelCase для методов.
Источник: https://google.github.io/styleguide/javaguide.html#s5.3-camel-case

### 2. Пробелы после if/for/while
До:    if(condition) {
После: if (condition) {
Почему: улучшает читаемость, отделяет ключевое слово от выражения.
Источник: Oracle Code Conventions — Whitespace

### 3. Длина строки: максимум 100 символов
До:    public List getStudentsFromSpecificCityWithVeryLongName...
После: public List getStudentsByCity(String city) {
Почему: длинные строки затрудняют чтение в редакторе и при code review.
Источник: https://google.github.io/styleguide/javaguide.html#s4.4-column-limit

### 4. Порядок импортов
До:    import java.util.List; import java.util.ArrayList; import java.io.File;
После: import java.io.File; import java.util.ArrayList; import java.util.List;
Почему: алфавитный порядок упрощает поиск импортов.
Источник: `config/checkstyle/checkstyle.xml` (`CustomImportOrder`) и проектная схема `.idea/codeStyles/Project.xml`

### 5. Фигурные скобки для if
До:    if (condition) doSomething();
После: if (condition) { doSomething(); }
Почему: скобки обязательны даже для однострочных блоков.
Источник: https://google.github.io/styleguide/javaguide.html#s4.1.1-braces-always-used

### 6. Использование двух пробелов вместо табуляции
До:      (TAB) public List getStudentsByCity(String city) {
После:   (2 spaces) public List getStudentsByCity(String city) {
Почему: каждый раз когда открывается новый блок отступ увеличивается на два пробела
Источник: https://google.github.io/styleguide/javaguide.html#s4.2-block-indentation

### 7. Импорт без wildcards
До:      import java.util.*;
После:   import java.util.List;
Почему: делают код менее предсказуемым, могут незаметно менять поведение при обновлении библиотек, замедляют чтение и ломают инструменты
Источник: https://google.github.io/styleguide/javaguide.html#s3.3.1-wildcard-imports

### badge
[![Java CI](https://github.com/Vladgleen8/devtools/actions/workflows/ci.yml/badge.svg)](https://github.com/Vladgleen8/devtools/actions/workflows/ci.yml)

## Code Review Checklist

### Функциональность
- [ ] Код решает поставленную задачу полностью
- [ ] Обработаны граничные случаи (null, пустые данные, экстремальные значения)
- [ ] Обработка ошибок реализована корректно

### Тесты
- [ ] Добавлены тесты для нового функционала
- [ ] Все тесты проходят локально: ./gradlew test
- [ ] Покрыты позитивные и негативные сценарии
- [ ] JaCoCo coverage >= 80% для нового кода

### Читаемость и стиль
- [ ] Имена переменных, методов и классов отражают назначение
- [ ] Нет дублирования кода (DRY)
- [ ] Checkstyle проходит без ошибок: ./gradlew checkstyleMain
- [ ] Нет закомментированного кода или отладочного вывода (System.out.println)

### Документация
- [ ] README обновлён (если добавлена новая функциональность)
- [ ] Публичные методы имеют JavaDoc (если применимо)
- [ ] Runbook обновлён (если изменились команды)

### Производительность и безопасность
- [ ] Нет очевидных проблем производительности
- [ ] Нет хардкода паролей, токенов или конфиденциальных данных


## Технологический стек проекта

### Языки и платформы
- Java 25 LTS — основной язык
- Gradle (через Gradle Wrapper) — система сборки

### Инструменты качества кода
- Checkstyle — статический анализ стиля (config/checkstyle/checkstyle.xml, ./gradlew checkstyleMain)
- JUnit 5 — тесты (./gradlew test)

### CI/CD
- GitHub Actions — Checkstyle и тесты на каждый коммит (.github/workflows/)

### Правила кода
- Стиль: Google Java Style (через Checkstyle)
- Коммиты: Conventional Commits (feat:, fix:, docs:)
- Ветки: feature/DVT-X, master — основная; PR обязателен для слияния



## Личный глоссарий терминов Dev Tools
### [Термин RU] — [Term EN]
**Определение:** [1-2 предложения]
**Контекст использования:** [где и зачем]
**Пример:** [применение в коде/команде]
**Источник:** [URL официальной документации]
### Общие IT

### Система контроля версий — Version Control
**Определение:** A version control system, or VCS, tracks the history of changes as people and teams collaborate on projects together. As developers make changes to the project, any earlier version of the project can be recovered at any time
**Контекст использования:** VCS используется в командной разработке и при индивидуальной работе для отслеживания истории изменений, восстановления предыдущих версий и понимания того, кто, что и когда менял . VCS позволяет:
Вернуть файлы или весь проект к предыдущему состоянию .
Сравнивать изменения во времени и видеть, кто последним менял файл, вызвавший проблему .
Вести прозрачную историю для всей команды, чтобы участники оставались согласованными, работая независимо .
Работать параллельно через ветки, безопасно предлагая изменения в production-код
**Пример:** Базовая настройка и первые команды Git:
bash
# Инициализация нового репозитория
git init
# Настройка имени и email (глобально)
git config --global user.name "Vladislav Medvedev"
git config --global user.email "you@example.com"
# Клонирование существующего репозитория
git clone https://github.com/USERNAME/REPO.git
# Проверка статуса изменений
git status
**Источник:** https://git-scm.com/book/en/v2/Getting-Started-About-Version-Control

### IDE - IDE
**Определение:** IDEs combine various capabilities needed for writing computer programs, including editing, building, testing, and packaging applications.
**Контекст использования:** IDE нужна разработчику в процессе написания кода, чтобы не переключаться между десятком отдельных инструментов. Вместо «редактор + компилятор + отладчик + система сборки + терминал» всё это собрано в одном окне.
**Пример:** Сборка проекта — кнопка Build (молоток) в IDEA или ./gradlew build в терминале.
Запуск тестов — зелёный треугольник рядом с классом теста или ./gradlew test.
Отладка — кнопка Debug (жучок) вместо Run; IDE сама подключает отладчик.
Запуск main — правый клик по классу → Run или java ru.mentee.power.ProgressDemo.
**Источник:** https://www.oracle.com/middleeast/developer/ide-developers/

### SDK— SDK
**Определение:** A Software Development Kit, or an SDK, is a collection of tools that you need to develop an application for a specific software framework. For example, to develop applications in Java, you need a Java SDK (JDK). SDKs contain binaries, source code for the binaries, and documentation for the source code. JDK builds also contain annotations.
**Контекст использования:** SDK используется разработчиками на этапе создания приложения для конкретной платформы или фреймворка. Он предоставляет готовые инструменты и библиотеки, чтобы не писать всё с нуля. SDK может быть глобальным — один SDK можно использовать в нескольких проектах и модулях. В IntelliJ IDEA «определить SDK» означает указать IDE, в какой папке на компьютере установлена нужная версия SDK; эта папка называется домашним каталогом SDK (SDK home directory).
**Пример:** В Java-разработке роль SDK выполняет JDK (Java Development Kit). JDK — это программный пакет, содержащий библиотеки, инструменты для разработки и тестирования Java-приложений, а также инструменты для запуска приложений на платформе Java (Java Runtime Environment – JRE). В IntelliJ IDEA SDK настраивается через File | Project Structure | Platform Settings | SDKs. Для сборки через Gradle JVM выбирается отдельно в настройках Gradle.
**Источник:** https://www.jetbrains.com/help/idea/sdk.html

### Репозиторий — Repository
**Определение:** A repository contains all of your code, your files, and each file's revision history . It's a place where you can store your code, your files, and each file's revision history .
**Контекст использования:** Репозиторий — базовый элемент для хранения и совместной работы над кодом. В нём ведётся вся история изменений, можно создавать ветки, обсуждать задачи через issues, предлагать изменения через pull requests . Репозитории бывают публичными.
**Пример:** Создание нового репозитория в текущей папке:
bash
git init
После этого файлы добавляются в отслеживание (git add) и фиксируются первым коммитом (git commit) .
**Источник:** https://docs.github.com/en/enterprise-cloud@latest/repositories/creating-and-managing-repositories/about-repositories

### Непрерывная интеграция и доставка — CI/CD
**Определение:** CI/CD is a method to frequently deliver apps to customers by introducing automation into the stages of app development. The main concepts attributed to CI/CD are continuous integration, continuous delivery, and continuous deployment. CI/CD is a solution to the problems integrating new code can cause for development and operations teams (CI/CD).
**Контекст использования:** CI/CD используется для автоматизации процессов сборки, тестирования и развёртывания приложений. Практика непрерывной интеграции (CI) требует частого коммита кода в общий репозиторий — каждый коммит автоматически собирается и тестируется, что позволяет обнаруживать ошибки раньше и снижает количество кода, которое нужно отлаживать . Непрерывная доставка (CD) расширяет это: код всегда готов к релизу, а развёртывание в продакшн происходит автоматически или по нажатию кнопки. В экосистеме Java/Gradle это реализуется через GitHub Actions, TeamCity, GitLab CI и другие инструменты
**Пример:** В проекте devtools CI/CD реализован через GitHub Actions — файл .github/workflows/ci.yml. Триггер срабатывает на push в ветки main и feature/**, а также на pull request в main. Workflow выполняет полный цикл: клонирование кода, установку JDK, проверку Checkstyle, запуск тестов, верификацию покрытия JaCoCo и сборку
**Источник:** https://docs.github.com/en/actions/get-started/continuous-integration

### Категория: Java-экосистема

#### JDK — Java Development Kit
**Определение:** Development environment for building Java applications; includes javac, jar, javadoc.
**Контекст:** нужен для компиляции кода в байт-код и сборки проекта.
**Пример:** java -version проверяет версию; в IDEA Project SDK указывает на установленный JDK.
**Источник:** https://docs.oracle.com/en/java/javase/

### JRE — Java Runtime Environment
**Определение:** The JRE is the software environment in which programs compiled for a typical JVM implementation can run. The runtime system includes:
Code necessary to run Java programs, dynamically link native methods, manage memory, and handle exceptions
Implementation of the JVM
**Контекст:** JRE нужна на машине конечного пользователя или на сервере, где приложение только запускается, но не разрабатывается. Если у тебя есть готовый .jar, для его запуска достаточно JRE. Для разработки же нужен полный JDK (Java Development Kit), который включает в себя JRE плюс компилятор javac, отладчик и другие инструменты. Начиная с Java 11 отдельный JRE больше не поставляется — внутри JDK есть всё необходимое, а для запуска можно собирать свои образы через jlink.
**Пример:** Запуск готового приложения на машине с установленной JRE  java -jar my-application.jar Здесь команда java берётся именно из JRE (или JDK, если установлен он). Если на сервере только JRE, javac в нём не будет — скомпилировать .java не получится.
**Источник:** https://docs.oracle.com/cd/E19455-01/806-3461/6jck06gqd/index.html

### JVM - Java Virtual Machine 
#### **Определение:** 
The Java Virtual Machine is the cornerstone of the Java platform. It is the component of the technology responsible for its hardware- and operating system-independence, the small size of its compiled code, and its ability to protect users from malicious programs. The Java Virtual Machine is an abstract computing machine. Like a real computing machine, it has an instruction set and manipulates various memory areas at run time.
#### **Контекст использования:** 
JVM нужна в момент запуска Java-приложения — она исполняет скомпилированный байт-код (.class), а не исходный код. Именно JVM обеспечивает кроссплатформенность: один и тот же .jar работает на Windows, Linux и macOS, потому что каждая ОС имеет свою реализацию JVM, но все они исполняют один и тот же байт-код. JVM отвечает за: загрузку классов (ClassLoader), управление памятью и сборку мусора (Garbage Collector), интерпретацию и JIT-компиляцию байт-кода в машинный код, проверку безопасности (bytecode verification), работу с потоками.
JVM — часть JRE (вместе с библиотеками классов), а JRE, в свою очередь, входит в JDK (вместе с компилятором и инструментами разработки).
#### **Пример:** 
Запуск класса с методом main — JVM стартует, загружает класс, исполняет байт-код java ru.mentee.power.devtools.progress.ProgressTracker
**Источник:** https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-1.html#jvms-1.2

### Gradle Wrapper — Gradle Wrapper
**Определение:** The recommended way to execute any Gradle build is with the help of the Gradle Wrapper (in short just “Wrapper”). The Wrapper is a script that invokes a declared version of Gradle, downloading it beforehand if necessary.
**Контекст использования:** Wrapper используется при запуске сборки Gradle-проекта на любой машине — без необходимости предварительно устанавливать Gradle. Он гарантирует, что все разработчики и CI-серверы используют одну и ту же версию Gradle, указанную в проекте. Это устраняет проблемы несовместимости между версиями Gradle и делает сборки воспроизводимыми. IntelliJ IDEA использует Wrapper по умолчанию как «recommended default option» для импорта Gradle-проектов.
**Пример:** В корне проекта лежат скрипты gradlew (Linux/macOS) и gradlew.bat (Windows). Запуск любой задачи выполняется через них вместо команды gradle :
bash
# Linux/macOS
./gradlew build
# Windows
gradlew.bat build
Если нужной версии Gradle нет локально, Wrapper скачает её автоматически и сохранит в GRADLE_USER_HOME .
**Источник:** https://docs.gradle.org/current/userguide/gradle_wrapper_basics.html

### Build Tool — Build Tool
**Определение:** Gradle Build Tool is the fast and dependable open source build system that automates building software of any type, size or complexity.
**Контекст использования:** Сборочный инструмент используется для автоматизации процесса сборки программного обеспечения — компиляции исходного кода, управления зависимостями, запуска тестов, упаковки артефактов и развёртывания. Gradle является стандартом для JVM-экосистемы (Java, Kotlin, Android) и обеспечивает воспроизводимые сборки благодаря кэшированию и параллельному выполнению задач . В IntelliJ IDEA сборка и тестирование делегируются Gradle, а Gradle Wrapper гарантирует использование конкретной версии инструмента .
**Пример:** В командной строке сборка запускается через Gradle Wrapper — скрипт gradlew (Linux/macOS) или gradlew.bat (Windows):
bash
# Запуск полной сборки проекта
./gradlew build
# Запуск только тестов
./gradlew test
# Просмотр доступных задач
./gradlew tasks
В IDE те же действия выполняются через панель Gradle tool window — двойной клик по задаче build в дереве проекта .
**Источник:** https://gradle.org/about-us/


### Категория: Инструменты разработки

#### Git — Git

### Commit - Commit
**Определение:** Similar to saving a file that's been edited, a commit records changes to one or more files in your branch
**Контекст использования:** Коммит используется для сохранения состояния проекта в определённый момент времени. Каждый коммит содержит уникальный идентификатор (SHA-хэш), который фиксирует: какие изменения были сделаны, когда и кем . Коммиты создают граф истории разработки, позволяя возвращаться к предыдущим состояниям, сравнивать версии и отслеживать эволюцию кода . В IntelliJ IDEA коммит выполняется через панель Commit (Alt+0), где можно выбрать файлы, ввести сообщение и зафиксировать изменения
**Пример:** Базовая команда коммита в терминале:
bash
git commit -m "Добавить вывод ветки в ProgressDemo"
**Источник:** https://docs.github.com/en/pull-requests/committing-changes-to-your-project/creating-and-editing-commits/about-commits

### Ветка — Branch
**Определение:** Branches let you develop features, fix bugs, or safely experiment with new ideas in a contained area of your repository . A branch in Git is simply a lightweight movable pointer to one of these commits .
**Контекст использования:** Ветка используется для изоляции работы над отдельной задачей (фичей, багфиксом, экспериментом) от основной линии разработки. Пока изменения в ветке не готовы, они не влияют на main или master. После завершения работы ветка сливается в основную через merge или Pull Request. В распределённых системах (Git) создание ветки — мгновенная операция, потому что это просто запись хэша коммита в файл. В IntelliJ IDEA все операции с ветками выполняются через всплывающее окно Git Branches.
**Пример:** В терминале создание и переключение на новую ветку:
bash
# Создать ветку feature/DVT-11
git branch feature/DVT-11
# Переключиться на неё
git checkout feature/DVT-11
Или одной командой:
bash
git checkout -b feature/DVT-11
В IntelliJ IDEA: правый нижний угол → иконка ветки → New Branch → ввести имя.
**Источник:** https://docs.github.com/en/enterprise-cloud@latest/pull-requests/reference/branches

### Пул-реквест — Pull Request
**Определение:** A pull request proposes merging code changes from one branch into another. As a collaborative feature, pull requests give you a place to discuss and review work before it becomes part of a project
**Контекст использования:** Pull request используется в командной разработке для предложения, обсуждения и слияния изменений кода из одной ветки в другую . Он превращает набор изменений в обсуждение, позволяя:
Ловить баги и проблемы до попадания в основную ветку .
Обсуждать изменения построчно, с привязкой комментариев к конкретным строкам .
Запускать автоматические проверки — тесты, сборки, сканирование кода .
Вести прозрачную историю того, что и почему изменилось .
PR не заменяет Git, а надстраивается над ним: изменения всё равно коммитятся и пушатся в ветку, но перед слиянием проходят ревью. В IntelliJ IDEA PR можно создать прямо из IDE: Git | GitHub | Create Pull Request .
**Пример:** Через веб-интерфейс: после пуша ветки на GitHub появляется баннер Compare & pull request → указываешь base (main) и compare (feature/DVT-11) → заполняешь описание → Create Pull Request .
**Источник:** https://docs.github.com/en/pull-requests/get-started/about-pull-requests

### Слияние — Merge
**Определение:** git merge используется для слияния одной или нескольких веток в ветку, в которой вы находитесь в данный момент. Затем он перемещает текущую ветку к результату слияния
**Контекст использования:** Слияние используется для интеграции изменений из одной ветки в другую. Типичный сценарий: вы работали в feature-ветке над задачей, а теперь хотите влить готовый код в основную ветку (main/master). Git создаёт новый merge-коммит, который объединяет изменения обеих веток от точки их расхождения . Это стандартный способ интеграции при работе через Pull Request.
**Пример:** Через GitHub: на странице PR нажми Merge pull request → Confirm merge. Если включён squash, будет Squash and merge
**Источник:** https://git-scm.com/docs/git-merge/ru.html

### Пуш — Push
**Определение:** The git push command is used to communicate with another repository, calculate what your local database has that the remote one does not, and then pushes the difference into the other repository
**Контекст использования:** Пуш используется для отправки зафиксированных коммитов из локальной ветки в удалённый репозиторий . Это ключевой шаг для публикации своей работы — после пуша изменения становятся доступны другим разработчикам, а на GitHub появляется возможность открыть Pull Request . Пуш требует прав на запись в удалённый репозиторий, поэтому обычно проходит аутентификацию (через SSH-ключ или Personal Access Token)
**Пример:** Пример:
bash
# Базовая команда: push <remote> <branch>
git push origin main
# Пуш с запоминанием upstream (чтобы потом достаточно было просто git push)
git push -u origin feature/DVT-11
**Источник:** https://git-scm.com/book/en/v2/Appendix-C:-Git-Commands-Sharing-and-Updating-Projects

### Пулл — Pull
**Определение:** Команда git pull работает как комбинация команд git fetch и git merge, т. е. Git вначале забирает изменения из указанного удалённого репозитория, а затем пытается слить их с текущей веткой
**Контекст использования:** Команда используется для синхронизации локальной ветки с удалённым репозиторием. Типичный сценарий: пока ты работал над своей задачей, другие разработчики запушили изменения в общую ветку на сервере. Чтобы получить эти изменения и сразу интегрировать их в свой локальный код, выполняется git pull. Это быстрее, чем делать git fetch, потом смотреть изменения, и только потом git merge — но и менее безопасно, потому что слияние происходит автоматически и может привести к конфликтам, которые придётся разрешать сразу
**Пример:** # Базовая команда: pull <remote> <branch>
git pull origin main
# Если upstream уже настроен (через git push -u), достаточно:
git pull
**Источник:** https://git-scm.com/book/ru/v2/%D0%9F%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D0%B5-C:-%D0%9A%D0%BE%D0%BC%D0%B0%D0%BD%D0%B4%D1%8B-Git-%D0%A1%D0%BE%D0%B2%D0%BC%D0%B5%D1%81%D1%82%D0%BD%D0%B0%D1%8F-%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0-%D0%B8-%D0%BE%D0%B1%D0%BD%D0%BE%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5-%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%BE%D0%B2

### Фетч — Fetch
**Определение:** The git fetch command communicates with a remote repository and fetches all the information that is in that repository that is not in your current one and stores it in your local database
**Контекст использования:** Fetch используется для безопасной синхронизации с удалённым репозиторием. Он загружает все новые коммиты, ветки и теги, которые появились на сервере, и обновляет локальные ссылки на удалённые ветки (origin/main и т.п.), но не трогает вашу рабочую директорию и локальные ветки . Это позволяет сначала посмотреть, что изменилось, сравнить с локальным состоянием и только потом решить, сливать (merge) или перебазировать (rebase).
**Пример:** 
# Базовая команда: fetch <remote>
git fetch origin
# С флагом --prune: удалить устаревшие ссылки на ветки, которых больше нет на сервере
git fetch --all --prune
**Источник:** https://git-scm.com/book/ru/v2/%D0%9F%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D0%B5-C:-%D0%9A%D0%BE%D0%BC%D0%B0%D0%BD%D0%B4%D1%8B-Git-%D0%A1%D0%BE%D0%B2%D0%BC%D0%B5%D1%81%D1%82%D0%BD%D0%B0%D1%8F-%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0-%D0%B8-%D0%BE%D0%B1%D0%BD%D0%BE%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5-%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%BE%D0%B2

### Prune — Prune
**Определение:** В контексте git fetch опция --prune предписывает удалить устаревшие ссылки на удалённые ветки, которых больше нет в удалённом репозитории . Это помогает поддерживать локальный список веток в актуальном состоянии, убирая «мёртвые» ссылки на ветки, удалённые на сервере.
**Контекст использования:** --prune используется для гигиены локального репозитория. Когда ты удаляешь ветку на GitHub (например, после merge PR), локальный Git всё ещё помнит её как origin/feature/old. Без --prune эти «призрачные» ветки остаются в git branch -r и в списке Remote Branches в IDE, создавая путаницу . Флаг --prune заставляет fetch проверять, какие ветки реально существуют на сервере, и удалять локальные ссылки на те, которых там уже нет.
**Пример:** 
# Синхронизировать все remote и удалить ссылки на удалённые ветки
git fetch --all --prune
# Или только для origin
git fetch --prune origin
**Источник:** В официальной документации Git (git-scm.com) дословного определения для prune как отдельного термина нет; описание --prune встречается в контексте команды git fetch https://git-scm.com/docs/git-fetch

### Категория: Процессы и практики
#### Code Review — Code Review

### Code Review - Code Review
**Определение:** Code review is the practice of having one or more developers examine another developer's code before it is merged into the main codebase, with the goal of identifying bugs, security vulnerabilities, and adherence to coding standards and best practices . This process helps catch errors, inconsistencies, and security flaws that the original developer might have missed .
**Контекст использования:** Контекст использования: Code review используется в командной разработке как обязательный этап перед слиянием изменений в основную ветку . Основные цели:
Повышение качества кода — ревьюеры проверяют корректность, читаемость, обработку граничных случаев и безопасность .
Распространение знаний — члены команды знакомятся с разными частями кодовой базы .
Соблюдение стандартов — проверка соответствия конвенциям проекта и языковым стайлгайдам .
Разделение ответственности — каждое изменение должно быть одобрено хотя бы одним другим разработчиком перед слиянием .
Процесс обычно встроен в Pull Request (GitHub) или Merge Request (GitLab, Oracle Developer Cloud Service). Ревьюер может оставлять строчные комментарии к конкретным строкам кода, отвечать на комментарии автора и выбирать вердикт: Approve, Request Changes или просто Comment.
**Пример:** В GitHub процесс ревью встроен в Pull Request:
Открой PR → вкладка Files changed.
Наведи курсор на строку → появится + → кликни для добавления строчного комментария .
Напиши комментарий по шаблону «Проблема → Почему важно → Предложение».
Выбери Add single comment (публикуется сразу) или Start a review (копит комментарии в черновик) .
После завершения нажми Review changes → выбери Approve, Request changes или Comment .
**Источник:** https://www.jetbrains.com/help/idea/review-code-in-space.html

### Само-ревью — Self-Review
**Определение:** A self-review can include reading the diff, checking for accidental changes, and making sure relevant builds or tests have run . In practice, it means reviewing your own pull request before asking others to look at it, to catch mistakes early and show that the changes are ready for their attention
**Контекст использования:** Self-review используется автором изменений до отправки на ревью другим разработчикам. Основные цели:
Раннее обнаружение ошибок — опечатки, случайные изменения, забытый отладочный код .
Повышение «approvability» — ревьюеру проще одобрить PR, который уже проверен и аккуратно оформлен .
Улучшение читаемости — если автор сам с трудом читает свой код, ревьюеру будет ещё сложнее .
Соблюдение границ scope — проверка, что в PR нет лишних изменений, не относящихся к задаче (scope creep) .
Экономия времени команды — меньше тривиальных комментариев от ревьюеров, фокус на архитектуре и логике .
**Пример:** ек-лист само-ревью обычно включает :
Проверка diff на случайные изменения
Запуск сборки и тестов (./gradlew build)
Проверка, что PR решает поставленную задачу и не выходит за её рамки
Чистота кода (нет закомментированного кода, отладочных System.out.println)
Читаемость имён и логики
**Источник:** https://docs.github.com/en/enterprise-server@3.19/pull-requests/concepts/helping-others-review-your-changes

### Runbook — Runbook
**Определение:** Runbooks allow you to capture procedural tasks for handling a workflow . Runbooks are the predefined procedures to achieve a specific outcome
**Контекст использования:** Runbook используется для документирования повторяющихся операционных процедур — чтобы любой член команды мог выполнить задачу по шагам, не полагаясь на память конкретного человека. Основные цели:
Снижение зависимости от ключевых сотрудников — знания фиксируются в документе, а не хранятся в головах .
Ускорение реакции на инциденты — оператор открывает runbook и идёт по шагам, не тратя время на разбирательство .
Снижение ошибок — пошаговая инструкция с ожидаемым результатом на каждом шаге уменьшает вероятность что-то забыть или сделать не в том порядке .
Воспроизводимость — одна и та же процедура выполняется одинаково разными людьми в разное время .
**Пример:** Runbook: Синхронизация main с origin/main
Предусловие: нет незакоммиченных изменений.
1. git status
   Ожидаемо: "nothing to commit, working tree clean"
2. git fetch --all --prune
   Ожидаемо: вывод без ошибок.
3. git pull --ff-only origin main
   Ожидаемо: "Fast-forward" или "Already up to date".
4. git rev-parse HEAD && git rev-parse origin/main
   Ожидаемо: одинаковые хэши.
**Источник:** https://docs.oracle.com/en-us/iaas/tools/oci-cli/3.63.0/oci_cli_docs/cmdref/fleet-apps-management/fleet-apps-management-runbooks/runbook.html

### Спринт - Sprint
**Определение:** В Scrum-разработке спринт — это установленный период времени, в течение которого должен быть выполнен заранее определённый набор задач и подготовлен к проверке. Каждый спринт можно рассматривать как короткий проект
**Контекст использования:** Спринт используется в Agile-разработке как контейнер для всех остальных Scrum-событий (планирование, ежедневные стендапы, обзор, ретроспектива). Основные цели:
Обеспечение предсказуемости — короткие циклы позволяют регулярно проверять и адаптировать прогресс в направлении цели продукта.
Ограничение рисков — продолжительность ограничена календарным месяцем, что снижает риски затрат и усилий.
Генерация циклов обучения — более короткие спринты (обычно от двух недель до 30 дней) создают больше возможностей для обратной связи.
**Пример:** В трекере задач (например, YouTrack) спринт — это набор активных задач, представленных в виде карточек на Agile-доске. В учебном проекте спринт может соответствовать одному заданию (например, DVT-11), в рамках которого создаётся ветка, выполняются коммиты и открывается Pull Request.
**Источник:** https://www.jetbrains.com/help/youtrack/server/work-with-sprints.html

## Вопросы по сложным темам


## Как называются тесты в этом проекте
```
Схема shouldРезультат_whenУсловие. Например, shouldThrowException_whenMenteeListIsEmpty сразу говорит, что проверяется и при каком условии — не нужно открывать тело теста, чтобы понять, что упало, при чтении отчёта CI.
Схема shouldРезультат_whenУсловие (уже использовалась в shouldFormatSummary_whenProgressCreated, shouldCalculateTotalProgress_whenMultipleMentees) — не формальность. Если тест падает в отчёте CI, ты читаешь ИМЯ метода, а не тело: shouldThrow_whenListIsEmpty говорит, что именно сломалось, до открытия кода. Плохое имя (test1, testMentee) заставляет каждый раз заново читать тело теста.
```