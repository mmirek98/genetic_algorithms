const formFieldsIds = [
  'rangeBegin',
  'rangeEnd',
  'populationCount',
  'chromosomeAccuracy',
  'epochsCount',
  'selectionParameter',
  'eliteStrategyAmount',
  'crossProbability',
  'mutationProbability',
  'inversionProbability',
  'selectionMethod',
  'crossMethod',
  'mutationMethod',
  'optimizationType'
];

function sendToJava() {
  console.log('sendToJava');
  formFieldsIds.forEach(id => {
    if (id !== 'selectionParameter') {
      javaConnector.sendParameter(id, getValueFromField(id));
    } else {
      javaConnector.sendParameter(id, calculateSelectionParameter())
    }
  });
}

function runLearning() {
  sendToJava();
  console.log('runLearning');
  javaConnector.run();
}

function calculateSelectionParameter() {
  const selectionMethod = getValueFromField('selectionMethod');
  let value = getValueFromField('selectionParameter');
  if (selectionMethod === 'best') {
    const percentageToKeep = 100 - value;
    return percentageToKeep / 100;
  }

  return value;
}

const getValueFromField = id => document.getElementById(id)?.value;