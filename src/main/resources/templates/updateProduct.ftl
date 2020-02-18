<!DOCTYPE html>
<html lang="en">
<head>
    <title>Обновление</title>
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

<h1>Обновление продукта</h1>

<br>

<form action="/products/update" method="post">
    <h3 style="width: 20%">Номер обновляемого продукта:</h3>
    <input type="number" name="id" required="required" min="1">
    <input type="submit" value="Обновить">
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