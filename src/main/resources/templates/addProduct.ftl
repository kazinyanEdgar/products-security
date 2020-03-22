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

    <div>
        <p>Название:</p>
        <input type="text" name="name" required>

        <p>Цена:</p>
        <input placeholder="1000" type="number" name="price" required min="1">
    </div>

    <br>
    <br>

    <div>
        <button type="submit">Добавить</button>
        <button type="reset">Очистить</button>
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