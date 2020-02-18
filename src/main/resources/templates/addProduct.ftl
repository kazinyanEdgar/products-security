<!DOCTYPE html>
<html lang="en">
<head>
    <title>Добавление</title>
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
<h1>Добавление продукта</h1>

<br>

<form action="/products/add" method="post">

    Название:<br>
    <input type="text" name="name" required="required">

    <br>
    <br>

    Цена:<br>
    <input type="number" name="price" required="required" min="1">

    <br>
    <br>

    <input type="submit" value="Добавить">
    <input type="reset" value="Очистить">

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