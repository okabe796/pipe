package pipe.views.builder;

import pipe.controllers.PetriNetController;
import pipe.views.arc.InhibitorArcView;
import uk.ac.imperial.pipe.models.component.arc.Arc;
import uk.ac.imperial.pipe.models.component.place.Place;
import uk.ac.imperial.pipe.models.component.transition.Transition;

public class InhibitorArcViewBuilder {
    private final Arc<Place, Transition> arc;
    private final PetriNetController controller;

    public InhibitorArcViewBuilder(Arc<Place, Transition> arc, PetriNetController controller) {
        this.arc = arc;
        this.controller = controller;
    }

    /*
    double startPositionXInput, double startPositionYInput,
    double endPositionXInput, double endPositionYInput,
    ConnectableView sourceInput,
    ConnectableView targetInput, LinkedList<MarkingView> weightInput,
    String idInput, boolean taggedInput, NormalArc model) {     */
    public InhibitorArcView build() {
        InhibitorArcView view =
                new InhibitorArcView(arc, controller);
        return view;

    }
}
