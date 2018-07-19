(function ($) {
  $.fn.stepWizard = function () {
    var _this = $(this);
    _this.each(function () {
      var wizard = $(this);
      var allTabs = wizard.find("[wizard-step]");
      
      /* Wizard had no content */
      if (allTabs.length == 0)
        return;
      var firstTab = $(allTabs[0]);
      showTab(firstTab, allTabs, 0);
      
      /* Button actions */
      wizard.find("button[wizard-next]").on("click", goToNextStep);
      wizard.find("button[wizard-previous]").on("click", goToPreviousStep);
    });
  }

  function showTab(tab, allTabs, currentIndex) {
    if (currentIndex == null) {
      currentIndex = allTabs.index(tab);
    }
    tab = $(tab);
    allTabs.not(tab).hide();
    tab.attr("current-step", true);
    allTabs.not(tab).removeAttr("current-step");
    tab.show("fast");
    var wizard = tab.closest("[wizard]");
    wizard.find("button[wizard-next]").toggle(currentIndex + 1 < allTabs.length);
    wizard.find("button[wizard-previous]").toggle(currentIndex > 0);
    wizard.find("input[wizard-last]").toggle(currentIndex + 1 == allTabs.length);
  }

  function goToNextStep() {
	  var button = $(this);
	  var wizard = button.closest("[wizard]");
	  var allTabs = wizard.find("[wizard-step]");
	  var currentTab = allTabs.filter("[current-step]");
	  var currentIndex = allTabs.index(currentTab) + 1;
	  var nextTab = allTabs[currentIndex];

	  var validationFunctionName = currentTab.attr("canexit");
	  if(!!validationFunctionName && window[validationFunctionName] != null) {
		  var validationValue = window[validationFunctionName]();
		  if(validationValue == false)
			  return;
	  }
	  showTab(nextTab, allTabs, currentIndex);
  }

  function goToPreviousStep() {
	    var button = $(this);
	    var wizard = button.closest("[wizard]");
	    var allTabs = wizard.find("[wizard-step]");
	    var currentTab = allTabs.filter("[current-step]");
	    var currentIndex = allTabs.index(currentTab) - 1;
	    var previousTab = allTabs[currentIndex];
	    /* Show the previous tab */
	    showTab(previousTab, allTabs, currentIndex);
  }
  

})(jQuery);