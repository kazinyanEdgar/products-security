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

    <div>
        <p>Номер обновляемого продукта:</p>
        <input placeholder="1" type="number" name="id" required min="1">
        <button type="submit">Обновить</button>
    </div>

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