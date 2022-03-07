<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
    <title>Kayıt Sayfası</title>
</head>
<body>
<h2>Kayıt Formu</h2>
<form method="post" action="kaydet">
    <fieldset>
        <legend>Kullanıcı Kayıt Formu</legend>
        İsim: <input type="text" name="isim" /><br />
        Soyisim: <input type="text" name="soyisim" /><br />
        Cinsiyet: <input type="radio" name="cinsiyet" value="1">Bay</input><input type="radio"
                                                                                  name="cinsiyet" value="2">Bayan</input><br />
        Sınıf: <select name="sinif">
        <option value="1">1. Sınıf</option>
        <option value="2">2. Sınıf</option>
        <option value="3">3. Sınıf</option>
        <option value="4">4. Sınıf</option>
    </select>
    </fieldset>
    <input type="submit" value="Kaydet" />
    <input type="reset" value="Temizle" />
</form>
</body>
</html>