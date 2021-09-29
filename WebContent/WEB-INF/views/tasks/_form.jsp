<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<label for="todo">タスク</label><br />
<input type = "text" name = "todo" value = "${task.content}"/>
<br /><br />

<input type = "hidden" name = "_token" value ="{_token}" />
<button type = "submit">作成</button>
