<!DOCTYPE html>
<html lang="en">
<head>
    <title>Обновление</title>

    <style>
        table, th {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 5px;
        }

        h1, h3 {
            border: 4px outset grey;
            border-radius: 12px;
            width: 10%;
            text-align: center;
        }

        hr {
            border: 4px double grey;
        }
    </style>

</head>
<body>


<h1 style="width: 25%">Обновление продукта с ID=${product.id}</h1>
<br>
<table style="width:20%">

    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Цена</th>
    </tr>

    <h3>Данные сейчас:</h3>
    <th>${product.id}</th>
    <th>${product.name}</th>
    <th>${product.price}</th>

</table>

<br>
<br>

<hr align="left" width="25%">
<hr align="left" width="25%">

<br>

<h3>Введите новые данные:</h3>
<form action="/products/updateProduct" method="post">

    <div>
        <p>Название:</p>
        <input placeholder="${product.name}" type="text" name="name" required>

        <p>Цена:</p>
        <input placeholder="${product.price}" type="number" name="price" required min="1">

        <input type="hidden" name="id" value="${product.id}">
    </div>

    <br>
    <br>

    <button type="submit">Перезаписать</button>
    <button type="reset">Очистить</button>

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