jQuery(function() {
	jQuery('a.external').click(function() {
		var href = jQuery(this).attr('href');
		if (window.parent.location != window.location) {
			window.parent.location = href;
			return false;
		}
		window.open(href);
		return false;
	});
});
