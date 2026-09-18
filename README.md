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

<p>

</p>