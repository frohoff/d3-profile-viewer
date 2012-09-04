(function() {
	var tk = document.createElement('script');
	tk.src = '//use.typekit.com/' + TypekitConfig.kitId + '.js';
	tk.type = 'text/javascript';
	tk.async = 'true';
	tk.onload = tk.onreadystatechange = function() {
		var rs = this.readyState;
		if (rs && rs != 'complete' && rs != 'loaded') return;
		try { Typekit.load(TypekitConfig); } catch (e) {}
	};
	var s = document.getElementsByTagName('script')[0];
	s.parentNode.insertBefore(tk, s);
})();
