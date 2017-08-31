function redireccionarPregunta(x,text) {
	if (confirm(text) == true) {
		window.location.assign("http://" + location.hostname+(location.port ? ':'+location.port: '') + x);
	} else {
		//window.location.assign(window.location.pathname + "#BOT");
	}
}