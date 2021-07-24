/**
* Code Expander for Wordpress CodeColorer plug-in
* Author: Matt Hobbs (http://nooshu.com/)
*/
$(document).ready(function () {
    if($(".codecolorer-container").length){
        var $code = $(".codecolorer-container").each(function(){
            var $this = $(this);

            //Animation decision object
            var decisionObject = {
                w: false,
                h: false
            };

            //Original width / height of the displayed code
            var originalWidth = $this.width();
            var originalHeight = $this.height();

            //Width / height of hidden portion of code
            var mainWidth = $this.find(".codecolorer").width();
            var mainHeight = $this.find(".codecolorer").height();
            var lineWidth = $this.find(".line-numbers").width();

            // Setting default properties for code area
            // Hide scroll bar
            $this.css("overflow", "hidden");
            // Wrap code
            $this.css("white-space", "normal");
            // Add margin
            $this.css("margin-left", "5px");
			$this.css("z-index", "4");


            //Only attach events if needed (ie has scroll bars)
            if((mainWidth + lineWidth) > originalWidth || mainHeight > originalHeight){
                //Uncomment if you use $.event.special.hover
                //$.event.special.hover.delay = 140;
                $this.bind({mouseenter: function(e){

                        // Show vertical scroll bar
                        $this.css("overflow-y", "scroll");

                        // Remove the margin from the original code
                        $this.css("margin-left", "0px");

                        //Current position in relation to the page
                        var offsetTop = $this.offset().top;
                        var offsetLeft = $this.offset().left;

                        //Clone the code and attach it to the page
                        $this.clone().css({
                            position: "absolute",
                            top: offsetTop,
                            left: offsetLeft,
                            "margin-left": "5px",   // Add the margin for the clone
                        }).attr("id", "cloned").appendTo("body");

                        //Hide the code underneath
                        $this.css("visibility", "hidden");

                        //Detect what to animate
                        var animateObject;
                        if(mainWidth + lineWidth > originalWidth){decisionObject.w = true;}
                        if(mainHeight > originalHeight){decisionObject.h = true;}

                        var height_max = Math.min(mainHeight + 20, 850);
                        var width_max = Math.min(mainWidth + lineWidth + 40, 960);

                        if(decisionObject.w && decisionObject.h){
                            animateObject = {
                                height: height_max,
                                width: width_max
                            }
                        } else if(decisionObject.w){
                            animateObject = {width: width_max}
                        } else if(decisionObject.h){
                            animateObject = {height: height_max}
                        }

                        //Animate & add leave event
                        $("#cloned").animate(animateObject, 500).bind("mouseleave", function(){
                            var $cloned = $(this);
                            //Animate back and remove
                            $cloned.animate({
                                width: originalWidth,
                                height: originalHeight
                            }, 400, function(){
                                $cloned.remove();

                                // Restoring original code properties
                                // Re-Show the code underneath
                                $this.css("visibility", "visible");
                                // Re-Hide scroll bar for the original code
                                $this.css("overflow", "hidden");                              
                                // Re-Add the margin to the original code
                                $this.css("margin-left", "5px");
                            });
                        });
                }});
            }
        });
    }
});
