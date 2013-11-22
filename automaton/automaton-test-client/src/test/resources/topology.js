load("nashorn:mozilla_compat.js");
importPackage("be.appify.automaton.test.client");

robot.onEvent("topology", function(event) {
    var topology = new Topology();
    for(var i = 0; i < event.parameters().length; i++) {
        var parameter = event.parameters()[i];
        var type = parameter;
        var length = 0;
        if(parameter.contains(":")) {
            type = parameter.substring(0, parameter.indexOf(":"));
            length = java.lang.Integer.parseInt(parameter.substring(parameter.indexOf(":") + 1));
        }
        switch (type) {
            case "straight":
                topology.straight(length);
                break;
            case "curve":
                topology.curve(length);
                break;
            case "loop":
                topology.closeLoop();
                break;
        }
    }
    robot.variable("topology", topology);
});