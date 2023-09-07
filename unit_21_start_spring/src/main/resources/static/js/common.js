function attachUser(depId, empId) {
    console.log('empId', empId)
    console.log('depId', depId)
    submitRequest(depId, empId, true)
}

function detachUser(depId, empId) {
    console.log('empId', empId)
    console.log('depId', depId)
    submitRequest(depId, empId, false)
}

function submitRequest(depId, empId, attachOrDetach) {
    let depAttachSubmit = document.getElementById('depAttachSubmit');
    if (depAttachSubmit) {
        let depAttach = document.getElementById('depAttach');
        let input = document.createElement("input");
        input.setAttribute("type", "hidden");
        input.setAttribute("name", "depId");
        input.setAttribute("value", depId);
        depAttach.appendChild(input);
        input = document.createElement("input");
        input.setAttribute("type", "hidden");
        input.setAttribute("name", "empId");
        input.setAttribute("value", empId);
        depAttach.appendChild(input);
        input = document.createElement("input");
        input.setAttribute("type", "hidden");
        input.setAttribute("name", "attachOrDetach");
        input.setAttribute("value", attachOrDetach);
        depAttach.appendChild(input);
        depAttachSubmit.click();
    }
}
