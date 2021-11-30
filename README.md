# Isida_Informatics

Для запуска вам потребуется: 

*Если на вашем компьютере уже установлена IntelliJ Idea, Git, MySQL Community Server 
и проведены необходимые подключения вы можете пропустить пункты: 1 - 6

1. Скачайте и установите последнюю версию JDK на свой компьютер:
https://adoptopenjdk.net/

2. Скачать и установить последнюю версию среды разработки IntelliJ Idea Community Edition

3. Скачайте и установите систему контроля версий Git на свой компьютер:
https://git-scm.com/

4. Скачайте и установите MySQL Community Server (Вожно запомеить пароль!)

5. Подключите к среде разработки IntelliJ Idea установленную на своём компьютере JDK

6. Подключите к среде разработки IntelliJ Idea установленный на своём компьютер Git
 
7. Скачайте на свой локальный компьютер проект из GitHub: 
7.1 откройте IntelliJ Idea
7.2 нажмите кнопку Get from VCS
7.3 в поле Version control: выбирете Git
7.4 выберите директорию в которую будет загружен проект
7.5 введите URL проекта 
7.6 нажмите кнопку Clone

https://www.jetbrains.com/help/idea/manage-projects-hosted-on-github.html#clone-from-GitHub

URL проекта: https://github.com/Alexandr-Kozhekin/Isida_Informatics.git

8. В application.properties укажите имя (стандартное: root) и пароль (введенный при установке MySQL Community Server) 
для подключения к базе данных (application.properties находится в пакете src.main.resources):

database.user.name= ____________(root)
database.user.password= ____________
      
9. В IntelliJ Idea запустите скачаный проект

10. Для анализа ссылки используйте: 
http://localhost:8080/
