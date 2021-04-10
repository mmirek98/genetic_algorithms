const setFieldValue = (id, value) => document.getElementById(id).value = value;

function handleSelectionMethodChange() {
    const selectionMethod = document.getElementById('selectionMethod').value;
    console.log('selection: ', selectionMethod);
    const selectionParameterField = {
        container: document.getElementById('selectionParameterContainer'),
        label: document.getElementById('selectionParameterLabel'),
        value: document.getElementById('selectionParameter')
    };

    switch (selectionMethod) {
        case 'best':
            // document.getElementById('selectionParameterLabel').innerText = 'best';
            setParameterFieldForBestSelection(selectionParameterField);
            break;
        case 'tournament':
            // document.getElementById('selectionParameterLabel').innerText = 'tour';
            setParameterFieldForTournamentSelection(selectionParameterField);
            break;
        default:
            // document.getElementById('selectionParameterLabel').innerText = 'other';
            unsetParameterSelectionField(selectionParameterField);
            break;
    }
}

function setParameterFieldForBestSelection(field) {
    field.container.style.display = 'flex';
    field.label.innerText = 'Best chromosome preservation amount (in %):';
    field.value.value = 1;
}

function setParameterFieldForTournamentSelection(field) {
    field.container.style.display = 'flex';
    field.label.innerText = 'Tournament chromosome squad amount:';
    field.value.value = 3;
}

function unsetParameterSelectionField(field) {
    field.container.style.display = 'none';
    field.label.innerText = '';
    field.value.value = 0;
}

function setToDefault() {
    setFieldValue('rangeBegin', 1);
    setFieldValue('rangeEnd', 10);
    setFieldValue('populationCount', 100);
    setFieldValue('chromosomeAccuracy', 6);
    setFieldValue('epochsCount', 1000);
    setFieldValue('eliteStrategyAmount', 10);
    setFieldValue('crossProbability', 0.6);
    setFieldValue('inversionProbability', 0.1);
    setFieldValue('epochsCount', 1000);
    setFieldValue('selectionParameter', 30);

    formFieldsIds.forEach(id => setFieldAsValid(id))
}