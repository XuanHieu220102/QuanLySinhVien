<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ALL students</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="p-5">
            <h1 class="text-center">All students</h1>
        </div>
        <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">USERNAME</th>
                <th scope="col">EMAIL</th>
                <th scope="col">CLASS</th>
                <th scope="col">KHOA</th>
              </tr>
            </thead>
            <tbody>
                    <td th:text = "${student.id}"></td>
                    <td th:text = "${student.name}"></td>
                    <td th:text = "${student.email}"></td>
                    <td th:text = "${student.lop}"></td>
                    <td th:text = "${student.khoa}"></td>
            </tbody>
          </table>
    </div>
</body>
</html>