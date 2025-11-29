<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h1>用户列表</h1>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>用户名</th>
                <th>年龄</th>
            </tr>
        </thead>
        <tbody>
            <#list users as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                </tr>
            </#list>
        </tbody>
    </table>

    <p>总用户数: ${users?size}</p>
</body>
</html>