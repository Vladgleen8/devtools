<p>Quick Start — команды ./gradlew run, ./gradlew test. </p>
<p>Packages —  пакет ru.mentee.power содержит Record MenteeProgress и класс ProgressDemo </p>
<p>Таблица полей MenteeProgress: menteeName типа String, sprintNumber типа int, plannedHoursPerWeek типа int, правило readyForSprint() </p>

### Git локальный цикл
<pre>После добавления новых инструментов — обновляйте .gitignore и делайте санитарный коммит при необходимости.
Если случайно удалили файлы без --cached, восстановитесь из локальной истории/изменений IDE.
Перед push проверяйте «status clean» в IDE и CLI; при расхождениях — ищите источник (новые артефакты/настройки).
</pre>

### Правило веток: feature/DVT‑X


### DVT-4
<p>ссылка на пр DVT-3 https://github.com/Vladgleen8/devtools/pull/1</p>
<p>git remote -v
origin  git@github.com:Vladgleen8/devtools.git (fetch)
origin  git@github.com:Vladgleen8/devtools.git (push)
</p>
<p>git branch -vv
  feature/DVT-3 6452749 [origin/feature/DVT-3] Обновить README для локального Git
* feature/DVT-4 0581d2f [origin/feature/DVT-4] Merge pull request #1 from Vladgleen8/feature/DVT-3
  main          0581d2f [origin/main] Merge pull request #1 from Vladgleen8/feature/DVT-3
</p>

<p>
git log --oneline --decorate
0581d2f (HEAD -> feature/DVT-4, origin/main, origin/feature/DVT-4, main) Merge pull request #1 from Vladgleen8/feature/DVT-3
6452749 (origin/feature/DVT-3, feature/DVT-3) Обновить README для локального Git
0125f77 Добавить вывод ветки в ProgressDemo
951e298 Добавить локальный шаблон и правило веток
a3e5f78 Добавить локальный шаблон и правило веток
</p>

### Сценарий ручной проверки DVT-6
Запуск
./gradlew run Ожидаемый вывод: Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков

Тесты
./gradlew test Ожидаемый вывод: BUILD SUCCESSFUL, все тесты зелёные

Debug
Breakpoint на while (index < mentees.length) в ProgressTracker
Debug 'ProgressTracker.main()', Step Over (F8) x3
Variables: index/totalCompleted/totalTotal растут как в таблице урока
Evaluate Expression: totalCompleted + mentees[index].completedLessons() = 25 (после 2-й итерации)
При ошибках
Вывод неверный → проверь цикл через Debug
Тесты красные → открой Test Report, найди AssertionError
Breakpoint не срабатывает → убедись, что запущен Debug, не Run

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
  
## Примеры Code Review комментариев

### Конструктивный №1 — цикл while с ручным индексом
Проблема: В методе calculateTotalProgress (строки 8–13) используется while (index < mentees.length) с ручным инкрементом index++. Индекс нужен только для доступа к элементу массива, никакой другой логики вокруг него нет.
Почему это важно: Ручной индекс — лишняя точка отказа. Забыл index++ — бесконечный цикл. Опечатался в условии — выход за границы массива. Плюс while с индексом читается медленнее, чем for-each: чтобы понять «пройти по всем элементам», надо мысленно пройти весь цикл, а не увидеть это в одной строке.
Предложение: Заменить на for-each
Почему это хороший комментарий: Указывает на конкретную строку, объясняет «почему», а не просто «так надо», тон нейтральный — про код, не про человека

### Конструктивный №2 — имя переменной totalTotal
Проблема: Имя переменной totalTotal (строка 4) дублирует слово «total» и плохо различается с соседней totalCompleted (строка 3) при быстром просмотре кода.
Почему это важно: Имена переменных — основной способ понять, что происходит в методе, без чтения тела. Когда две переменные отличаются только вторым словом, глаз спотыкается, а при чтении диффа в PR легко перепутать одну с другой. Это замедляет ревью и повышает шанс ошибки при будущих правках.
Предложение: Переименовать в пару с симметричной семантикой:
totalTotal → totalLessons
totalCompleted → completedLessons
Почему это хороший комментарий: Конкретика, предлагает решение с альтернативой, спрашивает, а не утверждает, пишет про код, не про человека

### Токсичный №1 — цикл while
Проблема: while с индексом в calculateTotalProgress.
Почему это важно: В Java давно есть for-each, и писать через while с index++ — прошлый век. Такой код даже стыдно ревьюить.
Предложение: Перепиши нормально.
Почему это плохой комментарий: Переход на личности, нет конкретики, нет альтернативы, обесценивание

### Токсичный №2 — имя totalTotal
Проблема: totalTotal.
Почему это важно: Невозможно читать. Ты вообще думаешь, когда код пишешь?
Предложение: Переименуй.
Почему это плохой комментарий: Обесценивание автора, нет альтернативы, враждебный тон

## Результаты само-ревью DVT-9
1. Удалил избыточный комментарий в ProgressTracker
2. Добавил обработку null в методе addStudent класса StudentList теперь выкиыдвается exception
3. Удалил отладочный вывод в консоль в ProgressDemo
4. Удалил дублирующуся переменную в ProgressDemo
5. Скорректировал названия переменных в ProgressTracker заменив totalCompleted -> completedLessons, totalTotal -> totalLessons
6. Скорректировал дублирующееся имя у @DisplayName в тестах
7. Скорректировал тест на проверку метода addStudent так как теперь выкидывается Exception