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