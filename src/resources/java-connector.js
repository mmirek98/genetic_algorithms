const formFieldsIds = [
  'rangeBegin',
  'rangeEnd',
  'populationCount',
  'bitsCount',
  'epochsCount',
  'chromosomeAmount',
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
    javaConnector.sendParameter(id, getValueFromField(id));
  });
}

function runLearning() {
  sendToJava();
  console.log('runLearning');
  javaConnector.run();
}

const getValueFromField = id => document.getElementById(id).value;