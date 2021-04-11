const invalidFields = new Set();
const getParent = id => document.getElementById(id)?.parentElement;
const setFieldAsInvalid = id => {
    document.getElementById(id).style.border = '2px solid red';
    invalidFields.add(id);
    updateButtonState();
}
const setFieldAsValid = id => {
    document.getElementById(id).style.border = 'none';
    invalidFields.delete(id);
    updateButtonState();
}

const appendHint = (id, hintText) => {
    const parent = getParent(id);
    const hint = document.createElement('small');
    hint.innerText = 'Begin range must be smaller than end range (a < b)';
    hint.style.color = 'red';
    hint.style.fontSize = '0.7rem';
    parent.appendChild(hint);
};
const removeHint = id => {
    const parent = getParent(id);
    const lastChildIndex = parent.childNodes.length - 1;
    parent.removeChild(parent.childNodes[lastChildIndex]);
}

function validateRange(id) {
    const minRange = parseInt(getValueFromField('rangeBegin'));
    const maxRange = parseInt(getValueFromField('rangeEnd'));

    if (!getValueFromField(id)) setFieldAsInvalid(id);
    else if (minRange > maxRange) setFieldAsInvalid(id);
    else {
        setFieldAsValid('rangeBegin');
        setFieldAsValid('rangeEnd');
    }
}

function validateIntBoundary(id, a, b) {
    const value = parseInt(getValueFromField(id));

    console.log(value)

    if (!getValueFromField(id)) setFieldAsInvalid(id);
    else if (value < a || value > b) setFieldAsInvalid(id);
    else setFieldAsValid(id);
}

function validateFloatBoundary(id, a, b) {
    const value = parseFloat(getValueFromField(id));

    if (!getValueFromField(id)) setFieldAsInvalid(id);
    else if (value < a || value > b) setFieldAsInvalid(id);
    else setFieldAsValid(id);
}

function validateEliteAmount(id) {
    const populationCount = parseInt(getValueFromField('populationCount'));
    const eliteAmount = parseInt(getValueFromField(id));

    if (!getValueFromField(id)) setFieldAsInvalid(id);
    else if (eliteAmount > populationCount) setFieldAsInvalid(id);
    else setFieldAsValid(id);
}

function updateButtonState() {
    const runButton = document.getElementById('run');
    if (isFormValid()) {
        runButton.disabled = false;
        return;
    }
    runButton.disabled = true;
}

function isFormValid() {
    return invalidFields.size === 0;
}