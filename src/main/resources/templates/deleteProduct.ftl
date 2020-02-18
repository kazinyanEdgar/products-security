<!DOCTYPE html>
<html lang="en">
<head>
    <title>Удаление</title>
    <style>
        h1 {
            border: 4px outset grey;
            border-radius: 12px;
            width: 20%;
            text-align: center;
        }
    </style>
</head>
<body>

<h1>Удаление продукта</h1>

<br>

<form action="/products/delete" method="post">
    <h3 style="width: 15%">Номер удаляемого продукта:</h3>
    <input type="number" name="id" required="required" min="1">
    <input type="submit" value="Удалить">
</form>

<br>
<br>
<br>

<a href="/main">Перейти в главное меню</a>

<br>
<br>
<br>

<a href="/logout">Выйти из системы</a>

</body>
</html>