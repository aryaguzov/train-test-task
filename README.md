We are building a train ... the structure described in the following and the associated
functionalities are to be implemented in Java:
• A train consists of one or more locomotives and none or more wagons.
• Locomotives and wagons have a fixed empty weight.
• Locomotives and wagons have a fixed length.
• Elements of within a train have a certain order.
• Each locomotive has a certain tractive effort, this indicates how much weight
the locomotive can pull, in addition to its own curb weight.
• Each locomotive can carry a certain number of passengers (0 or more) and has a
maximum loading weight for goods (0 or more).
• Each locomotive has a type of designation, a manufacturer, a year of production
and a unique serial number.
• Locomotives are classified according to the engine types: diesel, steam and
electric.
• There are more arts of wagons (passenger’s wagons, sleeping wagons, dining
wagons, goods wagons).
• Each wagon can carry a certain number of passengers (0 or more) and has a
maximum loading weight for goods (0 or more).
• Each wagon has a type of designation, a manufacturer, a year of production and
a unique serial number.
• The empty weight of the entire train can be queried.
• The maximal number of passengers per train can be queried.
• The maximal loading weight for goods can be queried.
• The maximal loading of one train can be queried (=the maximal number of
passengers in train x 75 kg + the maximal loading weight for goods).
• The maximal total weight of the train can be queried.
• The length of the train can be queried.
• It should be possible to check whether the train is capable to drive. That is,
whether those on the train existing locomotives are able to pull the train with
maximal loading (passengers and goods) to pull.
• If the train has more than 0 maximal passengers - a conductor will be needed
on that train.
• The conductor is needed for every 50 possible passengers.
• The maximal number of necessary conductors per train can be queried.
• Locomotives or wagons can only be assigned to one train at a time.
• The composition of trains can be changed.
• Further checks are to be integrated depending on the implementation, for
example no cycles may occur within a train - wagon A is connected to wagon B
and wagon B is connected to wagon A.
• The correct functionality is to be checked by means of JUnit tests.
