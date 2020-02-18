<!DOCTYPE html>
<html lang="en">
<head>
    <title>Продукты</title>

    <style>
        table, th {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 5px;
        }

        h1 {
            border: 4px outset grey;
            border-radius: 12px;
            width: 10%;
            text-align: center;
        }
    </style>

</head>
<body>

<#if products?has_content>

    <h1>Продукты</h1>

    <table style="width: 30%">
        <tr>
            <th>Id</th>
            <th>Название</th>
            <th>Цена</th>
        </tr>

        <#list products as product>
            <tr>
                <th>${product.id}</th>
                <th>${product.name}</th>
                <th>${product.price}</th>
            </tr>
        </#list>
    </table>

<#else>

    <h1 style="border: 6px double grey;width: 15%; text-align: center;">Продуктов нет</h1>

</#if>

<br>
<br>
<br>

<a href="/main">Перейти в главное меню (только для сотрудников)</a>

</body>
</html>