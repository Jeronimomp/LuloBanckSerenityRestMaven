#Author: angeldavvid41@gmail.com
@tag
Feature: Validar información de empleados  usando Serenity Rest
  Yo como automatizador
  deseo hacer operaciones con los principales verbos del Api (POST, GET, DELETE)


  @Get1
  Scenario: Consulta de todos los empleados
    When se consulta el servicio web de todos los empleados
    Then se valida el mensaje de exito "Successfully! All records has been fetched."

  @Get2
  Scenario Outline: Consultar un empleado por Id
    When consultar usuario con id
      | id   |
      | <id> |
    Then Deberia ver la informacion del usuario
      | id   | employee_name   | employee_salary   | employee_age   | message   |
      | <id> | <employee_name> | <employee_salary> | <employee_age> | <message> |


    Examples:
      | id | employee_name      | employee_salary | employee_age | message                                |
      | 5  | Airi Satou         | 162700          | 33           | Successfully! Record has been fetched. |
      | 6  | Brielle Williamson | 372000          | 61           | Successfully! Record has been fetched. |


  @Post
  Scenario: Crear un empleado de forma exitosa
    When se crea un empleado con los siguiente datos
      | name          | salary | age |
      | Angel Marzola | 300000 | 20  |
    Then se velida el empleado creado con codigo de exito 200

  @Delete
  Scenario: Eliminar un empleado por id
    When se busca el empleado a eliminar por
      | id |
      | 5  |
    Then se observa el mensaje de eliminación
      | mensaje                               |
      | Successfully! Record has been deleted |
